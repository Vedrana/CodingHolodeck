'''
a x 1 = 192
a x 2 = 384
a x 3 = 576


a cannot be a two digit number:
  a x 1 + a x 2 + a x 3 -> max 8 digits
  a x 1 + a x 2 + a x 3 + a x 4 -> min 11 digits
  
a cannot be a three digit number:
  a x 1 + a x 2 -> max 7 digits
  a x 1 + a x 2 + a x 3 -> min 11 digits  
'''
def isPandigital(*numbers):
  identity = ''.join(map(str, numbers))
  if len(identity) != 9:
    return False
  digits = set(int(char) for char in identity)
  digits.discard(0)
  return len(digits) == 9
  
def main():
  for a in range(9999, 899, -1):
    if isPandigital(a, a*2):
      print str(a) + " " + str(a) + str(a*2)
      break

if __name__ == '__main__':
  main()
