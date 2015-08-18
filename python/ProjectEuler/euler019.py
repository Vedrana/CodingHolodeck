import datetime

def daterange(start_date, end_date):
  for n in range(int ((end_date - start_date).days)):
    yield start_date + datetime.timedelta(n)

def main():
  start_date = datetime.date(1901, 1, 1)
  end_date = datetime.date(2000, 12, 31) 
  number_of_sundays = 0
  for single_date in daterange(start_date, end_date):
      if single_date.day == 1 and  single_date.weekday() == 6:
        number_of_sundays += 1
  print number_of_sundays

if __name__ == '__main__':
  main()

