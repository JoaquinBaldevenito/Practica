
catalan:: Int -> Int 
catalan 0 = 1
catalan n = sum[catalan (i-1) * catalan (n-i) | i<-[1..n]]



