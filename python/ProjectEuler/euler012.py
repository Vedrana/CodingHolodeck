import math

def numberOfDivisors(num):
  root = int(math.sqrt(num))
  if int(math.sqrt(num)) == math.sqrt(num):
    divs = -1
  else:
    divs = 0
  for i in range(1, root + 1):
    if num % i == 0:
      divs += 2
  return divs

if __name__ == '__main__':
  n = 7
  while True:  
    triangNum = (n * (n+1)) / 2
    n += 1
    if numberOfDivisors(triangNum) > 500:
      print triangNum
      break
