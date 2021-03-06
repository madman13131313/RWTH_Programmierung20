data MultTree a = Index a a [MultTree a]| Daten a deriving Show 

t1:: MultTree Int
t1 = Index 3 42 [Index 3 15 [Daten 3, Daten 11, Daten 12], Index 19 42 [Daten 42, Daten 23]]

verzweigungsgrad:: MultTree a -> Int
verzweigungsgrad (Daten w) = 0
verzweigungsgrad (Index w1 w2 ms) = max (length ms) (verzweigungsgrad2 ms)
    where 
        verzweigungsgrad2:: [MultTree a] -> Int
        verzweigungsgrad2 [] = 0
        verzweigungsgrad2 (x:xs) = max (verzweigungsgrad x) (verzweigungsgrad2 xs)

apply:: [a] -> (a -> [b]) ->[b]
apply [] _ = []
apply (x:xs) f = f x ++ apply xs f

datenListe:: MultTree a -> [a]
datenListe (Daten w) = [w]
datenListe (Index w1 w2 []) = []
datenListe (Index w1 w2 ms) = apply ms datenListe

maxInListe:: [Int] -> Int 
maxInListe (x:xs) = max x (maxInListe xs)

minInListe:: [Int] -> Int 
minInListe (x:xs) = min x (minInListe xs)



datenIntervalle:: MultTree Int -> MultTree Int 
datenIntervalle (Daten w) = Daten w
datenIntervalle (Index w1 w2 []) = Index minBound maxBound []
datenIntervalle (Index w1 w2 ms) = Index (minInListe (apply ms datenListe)) (maxInListe (apply ms datenListe)) (datenIntervalleListe ms)
    where 
        datenIntervalleListe::[MultTree Int] -> [MultTree Int]
        datenIntervalleListe [] = []
        datenIntervalleListe (x:xs) = datenIntervalle x:datenIntervalleListe xs 

contains:: MultTree Int -> Int -> Bool 
contains (Daten w) v = w == v
contains (Index _ _ []) _ = False 
contains (Index w1 w2 _) v | v < w1 = False 
                           | v > w2 = False 
                           | v == w1 = True 
                           | v == w2 = True 
contains (Index w1 w2 (x:xs)) v | contains x v = True 
                              | otherwise = contains (Index w1 w2 xs) v