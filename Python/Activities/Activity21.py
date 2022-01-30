import pytest

def test_add():
    num1 = 5
    num2 = 4

    sum = num1 + num2

    assert sum == 9

def test_sub():
    num1 = 10
    num2 = 3

    diff = num1 - num2

    assert diff == 7

def test_mul():
    num1 = 8
    num2 = 5

    prod = num1 * num2

    assert prod == 40

def test_div():
    num1 = 30
    num2 = 15

    quo = num1 / num2

    assert quo == 2