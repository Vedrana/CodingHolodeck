import math

def sumOfProperDivisors(num):
  sumOfDivisors = 0
  for i in range(1, num):
    if num % i == 0: sumOfDivisors += i
  return sumOfDivisors

def isAmicable(num):
  sum_of_divisors = sumOfProperDivisors(num)
  sum_of_divisors_of_sum_of_divisors = sumOfProperDivisors(sum_of_divisors)
  return sum_of_divisors_of_sum_of_divisors == num, sum_of_divisors

def main():
  amicables = 0
  for num in range(0, 10000):
    friendly, sum_of_divisors = isAmicable(num)
    if friendly and sum_of_divisors < 10000 and sum_of_divisors > num:
      amicables = amicables + num + sum_of_divisors
  print amicables


if __name__ == '__main__':
  main()

