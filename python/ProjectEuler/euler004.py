def isPalindrome(n):
  s = str(n)
  for i in range(0,len(s) / 2 + 1):
    if s[i] != s[len(s) - 1 - i]:
      return False
  return True

if __name__== "__main__":
  biggest = 100 * 100
  for a in xrange(999, 99, -1):
    for b in xrange(999, 99, -1):
      if b < a or a * b < biggest:
        break
      if isPalindrome(a * b) and a * b > biggest:
        biggest = a * b
  print biggest