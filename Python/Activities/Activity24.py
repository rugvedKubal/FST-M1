import pytest

@pytest.fixture
def wallet():
    amount = 0
    return amount

@pytest.mark.parametrize("earned, spent, expected", [(30, 10, 20), (20, 2, 18)])
def test_sample(wallet,earned, spent, expected):
    wallet = wallet + earned
    wallet = wallet - spent
    assert wallet == expected