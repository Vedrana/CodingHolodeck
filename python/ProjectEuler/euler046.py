from euler import sieve

def main():
  primes = set([x for x in sieve(6000)])

  for i in range (33, 6000, 2):
    if i in primes:
      continue
    isCool = True
    for sq in [x**2 for x in range(i/2)]:
      if i - 2 * sq in primes:
        isCool = False
    if isCool:
      print i
      return
if __name__ == '__main__':
  main()