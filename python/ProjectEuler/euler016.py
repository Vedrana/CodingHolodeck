if __name__ == '__main__':
  print reduce(lambda x, y: x+y, [int(num) for num in str(2 ** 1000)])

