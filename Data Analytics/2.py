# import pandas as pd 

# data = { 
# "Population": [1400, 331, 67, 83], 
# "Capital": ["New Delhi", "Washington DC", "Paris", "Berlin"] 
# } 

# df = pd.DataFrame(data, index=["India", "USA", "France", "Germany"]) 
# print(df) 


# import pandas as pd 
# data = { 
# "Population": [1400, 331, 67, 83], 
# "Capital": ["New Delhi", "Washington DC", "Paris", "Berlin"] 
# } 
# df = pd.DataFrame(data, index=["India", "USA", "France", "Germany"]) 
# print(df.head()) 
# print(df.info())

# import pandas as pd 
# data = { 
# "Population": [1400, 331, 67, 83], 
# "Capital": ["New Delhi", "Washington DC", "Paris", "Berlin"] 
# } 
# df = pd.DataFrame(data, index=["India", "USA", "France", "Germany"]) 
# print(df.loc["India", "Population"]) 
# print(df[df["Population"] > 100]) 

# import pandas as pd 
# data = { 
# "Population": [1400, 331, 67, 83], 
# "Capital": ["New Delhi", "Washington DC", "Paris", "Berlin"] 
# } 
# df = pd.DataFrame(data, index=["India", "USA", "France", "Germany"]) 
# df["GDP"] = [3.5, 25, 2.9, 4.2] 
# df.rename(columns={"Population": "Population(M)"}, inplace=True) 
# df.drop(columns=["Capital"], inplace=True) 
# print(df)

import pandas as pd 
data = { 
"Population": [1400, 331, 67, 83], 
"Capital": ["New Delhi", "Washington DC", "Paris", "Berlin"] 
} 
df = pd.DataFrame(data, index=["India", "USA", "France", "Germany"]) 
print("Sorted by Population:") 
print(df.sort_values(by="Population")) 
print("Average Population:", df["Population"].mean())