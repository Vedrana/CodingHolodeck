from time import time
def main():
  perim = 0
  triplets = 0
  for p in range(1, 100000):
    num_of_triplets = 0
    for a in range(1, p/3):
      if (p*(p-2*a) % (2*(p-a)) == 0):
        num_of_triplets += 1
    if num_of_triplets > triplets:
      triplets = num_of_triplets
      perim = p
  print perim, triplets


if __name__ == '__main__':
  s = time()
  main()
  print time() - s

