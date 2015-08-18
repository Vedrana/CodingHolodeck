if __name__ == "__main__":
  import math
  a = 3
  b = 4
  for a in range(3, 1000):
    for b in range(a + 1, 1000):
      c = math.sqrt(a * a + b * b)
      if int(c) == c:
        c = int(c)
        if a + b + c == 1000:
          print a, b, c, a * b * c
          break