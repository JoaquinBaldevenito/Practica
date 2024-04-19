

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

subconjuntos :: [a] -> [[a]]
subconjuntos [] = [[]]
subconjuntos (x:xs) = subconjuntos xs ++ map (x:) (subconjuntos xs)

permutaciones [] = [[]]
permutaciones xs = [(y:p)|y<-xs, p<- permutaciones (filter (/= y) xs)]


intercalado :: [Int]-> [Int] ->[Int] -> Bool
intercalado xs [] ps = xs==ps
intercalado [] ys ps = ys==ps
intercalado xs ys [] = False
intercalado (x:xs) (y:ys) (p:ps)
        | x/=p && y/=p = False
        | x/=p && y==p = intercalado (x:xs) ys ps
        | x==p && y/=p = intercalado xs (y:ys) ps
        | x==p && y==p = intercalado (x:xs) ys ps || intercalado xs (y:ys) ps



tareasPerm :: [(Int,Int)] -> [(Int,Int)]
tareasPerm xs = tareas (permutaciones xs) [] maxBound 
        

tareas :: [[(Int,Int)]] -> [(Int,Int)] -> Int ->[(Int,Int)]
tareas [] tmin min = tmin
tareas (x:ps) tmin min  | aux x 1 < min = tareas ps x (aux x 1)  
                        | otherwise = tareas ps tmin min

aux :: [(Int,Int)] -> Int -> Int
aux [] dia = 0
aux (x:xs) dia  | fst x >= dia = aux xs (dia+1)
                |otherwise = snd x + aux xs (dia+1)

tareas2 :: [[(Int,Int)]] -> Int ->Int
tareas2 []  min = min
tareas2 (x:ps)  min  | aux x 1 < min = tareas2 ps  (aux x 1)  
                        | otherwise = tareas2 ps min

tareasPerm2 :: [(Int,Int)] -> Int
tareasPerm2 xs = tareas2 (permutaciones xs) maxBound 

terna :: Int -> [(Int,Int,Int)]
terna n = [(a,b,c)| a<-[1..n], b<-[1..n], c<-[1..n], c*c==b*b+a*a]
