import urllib2

def getNames():
  url = "http://projecteuler.net/project/names.txt"
  namesFile = urllib2.urlopen(url).read()
  names = [name.strip('" ') for name in namesFile.split(",")]
  names.sort()
  return names

def letterValue(letter):
  return ord(letter) - 64
  
def main():
  names = getNames()
  score = 0
  for i in range(len(names)):
    nameScore = reduce(lambda x, y: x + y, [letterValue(letter) for letter in names[i]])
    score += nameScore * (i + 1)
  print score

if __name__ == '__main__':
  main()

