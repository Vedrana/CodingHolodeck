import itertools
from euler import sieve

def isPandigital(number):
  identity = str(number)
  if '0' in identity:
    return False
  n = len(identity)
  for i in range(1, n+1):
    if str(i) not in identity:
      return False
  return True

def main():
  maxPrime = 0
  for prime in sieve(7654321):
    if isPandigital(prime):
      maxPrime = prime
  print maxPrime


if __name__ == '__main__':
  main()