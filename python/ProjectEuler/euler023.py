import math

def sumOfProperDivisors(num):
  sumOfDivisors = 0
  for i in range(1, num):
    if num % i == 0: sumOfDivisors += i
  return sumOfDivisors

def main():
  pass


if __name__ == '__main__':
  main()

