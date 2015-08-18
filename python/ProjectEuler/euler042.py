import urllib2

def getWords():
  url = "http://projecteuler.net/project/words.txt"
  wordsFile = urllib2.urlopen(url).read()
  words = [word.strip('" ') for word in wordsFile.split(",")]
  words.sort()
  return words

def letterValue(letter):
  return ord(letter) - 64
  
def triangleNumbersUpTo(n):
  triangle_numbers = []
  for i in range(0, n+1):
    triangle_numbers.append(i*(i+1)/2)
  return triangle_numbers
    
def main():
  words = getWords()
  triangle_numbers = triangleNumbersUpTo(100)
  triangle_words = 0
  for i in range(len(words)):
    wordScore = reduce(lambda x, y: x + y, [letterValue(letter) for letter in words[i]])
    if wordScore in triangle_numbers:
      triangle_words += 1
  print triangle_words

if __name__ == '__main__':
  main()

