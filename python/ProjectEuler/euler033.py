from __future__ import division

def main():
  for numerator in range(10, 99):
    for denominator in range(numerator+1, 100):
      if canFakeCancel(numerator, denominator):
        for num, den in fakeCancel(numerator, denominator):
          print str(numerator) + "/" + str(denominator) + " --- " + str(num) + "/" + str(den)

def canFakeCancel(numerator, denominator):
  return (str(numerator)[0] in str(denominator) or str(numerator)[1] in str(denominator)) \
         and str(numerator)[1] != "0"

def fakeCancel(numerator, denominator):
  frac = numerator / denominator
  n = str(numerator)
  d = str(denominator)
  den1 = int(d.replace(n[0], "", 1))
  den2 = int(d.replace(n[1], "", 1))
  
  if den1 != 0 and int(n[0]) / den1 == frac:
    yield int(n[0]), den1
  if den2 != 0 and int(n[1]) / den2 == frac:
    yield int(n[1]), den2

if __name__ == '__main__':
  main()

