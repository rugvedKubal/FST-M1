import pytest

def test_sumOfList(initializeListOfNums):
    sum = 0
    for num in initializeListOfNums:
        sum = sum + num
    assert sum == 55