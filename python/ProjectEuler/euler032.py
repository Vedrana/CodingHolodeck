def isPandigital(multiplicand, multiplier, product):
  identity = str(multiplicand) + str(multiplier) + str(product)
  if len(identity) != 9:
    return False
  digits = set()
  for char in identity:
    digits.add(int(char))
  digits.discard(0)
  return len(digits) == 9

def main():
  products = set()
  # 1 digit number * 4 digit number
  for i in range(1, 10):
    for j in range (1000, 9999):
      if isPandigital(i, j, i*j):
        products.add(i*j)
  # 2 digit number * 3 digit number
  for i in range(10, 100):
    for j in range (100, 999):
      if isPandigital(i, j, i*j):
        products.add(i*j)
  print reduce(lambda x, y: x + y, products)
      
  
if __name__ == '__main__':
  main()

