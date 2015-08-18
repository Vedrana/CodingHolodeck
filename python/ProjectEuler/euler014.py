
def nextNumber(number):
  if number % 2 == 0:
    return number / 2
  else:
    return 3 * number + 1

def chainLength(startNumber):
  length = 1
  next = startNumber
  while True:
    next = nextNumber(next)
    if next <= 1:
      return length
    length += 1

def main():
  maxLength, number = 0, 0
  for i in range(1, 1000000):
    if i % 1000 == 0:
      print i / 1000
    length = chainLength(i)
    if length > maxLength:
      maxLength, number = length, i

  print "Max length: ", maxLength
  print "For number: ", number

if __name__ == '__main__':
  main()

