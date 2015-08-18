def ugly():
  n1 = 1
  n2 = 2
  sumOfEvens = n2
  while True:
    s = n1 + n2
    if s > 4000000:
      break
    n1 = n2
    n2 = s
    if (n2 % 2 == 0):
      sumOfEvens += n2
  print sumOfEvens

def main():
  ugly()

if __name__ == '__main__':
  main()
