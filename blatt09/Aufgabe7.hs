data Optional a = Empty | Present a deriving Show 

mapOptional:: (a -> b) -> Optional a -> Optional b
mapOptional _ Empty = Empty
mapOptional f (Present o) = Present (f o)

filterOptional:: (a -> Bool) -> Optional a -> Optional a
filterOptional _ Empty = Empty
filterOptional f (Present o) = if f o then Present o
                               else Empty

foldOptional:: (a -> b) -> b -> Optional a -> b
foldOptional _ x Empty = x
foldOptional f _ (Present o) = f o

data Product = Article String Int deriving Show 

isHumanEatable:: Product -> Bool
isHumanEatable (Article "Dog Food" _) = False
isHumanEatable _ = True

adjustPrice:: Product -> Product
adjustPrice (Article a b) = if b < 1000 then Article a (2*b)
                            else Article a b

stringify:: Product -> String
stringify (Article a b) = "The Article named '" ++ a ++ "' costs " ++ show b ++ " Cents"

filterHumanEatable:: Product -> Optional Product
filterHumanEatable a = filterOptional isHumanEatable (Present a)

adjustPriceO:: Optional Product -> Optional Product 
adjustPriceO  = mapOptional adjustPrice 

stringifyO:: Optional Product -> String
stringifyO = foldOptional stringify "This article is unavailable."  

toPriceTag:: Product -> String
toPriceTag a = stringifyO(adjustPriceO(filterHumanEatable a))
