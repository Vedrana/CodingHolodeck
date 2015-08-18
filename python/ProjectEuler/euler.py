"""
Project Euler mega cool lib.
"""
import collections

def sieve(limit):
  a = [True] * limit
  a[0] = a[1] = False
  for (i, isprime) in enumerate(a):
    if isprime:
      yield i
      for n in xrange(i*i, limit, i):
        a[n] = False

"""
Perform function f on every item of multilevel list of strings while keeping the level structure
"""
def transform(lst, func=int):
  for item in lst:
    if isinstance(item, collections.Iterable) and not isinstance(item, str):
      yield list(transform(item, func))
    else:
      yield func(item)
