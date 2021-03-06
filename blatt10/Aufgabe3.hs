from :: Int -> [Int]
from x = x : from (x+1)

dropMult :: Int -> [Int] -> [Int]
dropMult x = filter (\y -> mod y x /= 0) 

dropall :: [Int] -> [Int]
dropall (x:xs) = x : dropall (dropMult x xs)

primes :: [Int]
primes = dropall (from 2)

primesBack :: [Int]
primesBack = drop 2 primes

primesProduct :: [Int]
primesProduct = zipWith (*) primes primesBack

com :: [Int] -> [Int] -> [Int]
com [] _ = []
com (x:xs) (y:ys) | x*x > y     = x:com xs ys
                  | otherwise = com xs ys

gutenPrimes :: [Int]
gutenPrimes = com (drop 1 primes) primesProduct
