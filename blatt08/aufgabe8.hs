isMatrix:: [[Int]] -> Bool
isMatrix [] = True
isMatrix [_] = True
isMatrix (x1:x2:xs) = (length x1 == length x2) && isMatrix (x2:xs)

dimensions::[[Int]] -> (Int,Int)
dimensions matrix = if isMatrix matrix then (numRow matrix, numCol matrix)
                    else (-1,1)

numRow::[[Int]] -> Int
numRow = length                  

numCol::[[Int]] -> Int
numCol matrix = length (matrix !! 0)

isQuadratic::[[Int]] -> Bool
isQuadratic matrix = if (isMatrix matrix) && (numCol matrix == numRow matrix) then True
                     else False

getRow::[[Int]] -> Int -> [Int]
getRow matrix i = if isMatrix matrix then matrix !! (i-1)
                  else []

getCol::[[Int]] -> Int -> [Int]
getCol []_ = []
getCol (start:matrix) i = if isMatrix (start:matrix) then (start !! i-1):(getCol matrix i) 
                          else []  

front::[[Int]] -> [Int]
front [] = []
front (start:matrix) = (start !! 0):(front matrix)

back::[[Int]] -> [[Int]]
back [] = []
back ((x:xs):matrix) = xs:(back matrix)

trav::[[Int]] -> [[Int]]
trav [] = []
trav [[]] = []
trav [[],_] = []
trav matrix = front(matrix):(trav (back matrix ))

setCol::[Int] -> Int -> Int -> [Int]
setCol (x:xs) j aij = if j>1 then x: setCol xs (j-1) aij 
                      else aij:xs

setEntry::[[Int]] -> Int -> Int -> Int -> [[Int]]
setEntry (start:matrix) i j aij = if i>1 then start:(setEntry matrix (i-1) j aij)
                                  else (setCol start j aij):matrix

addRow::[Int] -> [Int] -> [Int]
addRow [] [] = []
addRow (x:xs) (y:ys) = x+y:(addRow xs ys)

add::[[Int]] -> [[Int]] -> [[Int]]
add [] [] = []
add (start1:matrix1) (start2:matrix2) = if dimensions matrix1 == dimensions matrix2 && dimensions matrix1 /= (-1,-1) then (addRow start1 start2):(add matrix1 matrix2)
                                        else []