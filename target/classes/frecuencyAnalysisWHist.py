import numpy as np 
import matplotlib.pyplot as plt

filename = "test.txt"
data = np.loadtxt(filename)
hist, bin_edges = np.histogram(data, 10)
plt.hist(data, bins=bin_edges)
plt.show()