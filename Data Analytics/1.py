import numpy as np 

x = np.array([
 [10, 12, 14, 16, 18],
 [20, 22, 24, 26, 28],
 [30, 32, 34, 36, 38],
 [40, 42, 44, 46, 48]
])

# 1.1
# print("Shape: ",x.shape)
# print("Size: ",x.size)
# print("DataType: ",x.dtype)
# print("Sum: ",x.sum())


#1.2
# even_x = x[x%2==0]
# print(even_x)

#1.3
# third_col=x[:,2]
# print("Thrid Coloumn: ",third_col)

# second_row=x[1,:]
# print("Second Row: ",second_row)

# sub_matrix = x[1:3 , 2:5]
# print("Sub-Matrix: ",sub_matrix)

#1.4
# x[x > 30] = -1
# print("Modified Output: ",x)

# x[3] = [1, 2, 3, 4, 5]
# print("Array with 4th row changed: ",x)

#1.5
names = np.array(["Roxana", "Statira", "Roxana", "Statira",
"Roxana"])
scores = np.array([126, 115, 130, 141, 132])

score_LessThan30 = scores[scores < 130]
print("Scores less than 130",score_LessThan30)

statira_scores=scores[names == "Statira"]
print("Statira scores: ",statira_scores)

print("Previous Scores: ",scores)
scores[names == "Roxana"] += 10
print("New Scores: ",scores)

#part 2

#Q1

# row1 = -1 * np.ones((1, 4))
# row2 = np.zeros((1, 4))
# row3 = 2 * np.ones((1, 4))
# result = np.vstack((row1, row2, row3))
# print(result)

#Q2

# a=np.arange(12).reshape(3, 4)
# print(a)

# print("Adding 100 to each element: ",100 + a)

# print("Raising each element to the power of 2: ",2**a)

#Q3
# a1 = np.arange(10,50,2).reshape(4,5)
# print(a1)

# col3 = a1[:,2]
# print("Coloumn 3: ",col3)

# a1[3] = [1, 2, 3, 4, 5]
# print("Modified Array: ",a1)

#Q4

# import numpy as np

# names = np.array(["Roxana", "Statira", "Roxana", "Statira",
# "Roxana"])
# scores = np.array([126, 115, 130, 141, 132])

# score_LessThan30 = scores[scores < 130]
# print("Scores less than 130",score_LessThan30)

# statira_scores=scores[names == "Statira"]
# print("Statira scores: ",statira_scores)

# print("Previous Scores: ",scores)
# scores[names == "Roxana"] += 10
# print("New Scores: ",scores)



