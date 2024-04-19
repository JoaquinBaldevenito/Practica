

sublistas xs = [x| n<-[0..length (xs)],x<-[take n xs]]

permutations [] = [[]]
permutations xs = [x : ys | x <- xs, ys <- permutations (filter (/= x) xs)]

remover :: Eq t => [t] -> t -> [t]
remover [] _ = []
remover (x:xs) y    |x==y = xs
                    |otherwise = remover xs y

subc [] = [[]]
subc xs = subc (tail xs) ++ map (head xs:) (subc (tail xs))

sublists [] = [[]]
sublists (x:xs) = [x:sublist | sublist <- sublists xs] ++ sublists xs

anagrama [] [] = True
anagrama xs ys =  pertenece (permutations xs) ys

pertenece [] _ = False
pertenece (x:xs) k  |x == k = True
                    |otherwise = pertenece xs k

suma [] n = False
suma xs n = [] /= [ x | x <-subc xs,sum x == n]

esSubsecuencia xs ys = pertenece (permutations ys) xs

esSubcadena xs ys = pertenece (subc ys) xs

sorted :: Ord a => [a] -> Bool
sorted [] = True
sorted [x] = True
sorted (x:y:xs) = x <= y && sorted (y:xs)

slowSort :: (Eq a, Ord a) => [a] -> [a]
slowSort [] = []
slowSort xs = ord (permutations xs)

ord :: Ord a => [[a]] -> [a]
ord [] = []
ord (x:xs)  | sorted x = x 
            | otherwise = ord xs 

terna :: Int -> [(Int,Int,Int)]
terna n = [(a,b,c)| a<-[1..n], b<-[1..n], c<-[1..n], c*c==b*b+a*a]
