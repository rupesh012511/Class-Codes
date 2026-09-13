import pandas as pd

print("=== Missing Data Handling Program ===")

file_path = "C:\Users\DELL\Desktop\4 SEM\ANN & ML\Data Analytics/students_marks_raw.csv"

try:
    df = pd.read_csv(file_path)
    print("\nFile loaded successfully!\n")
except Exception as e:
    print("Error: Could not read the file.")
    print(e)
    exit()

print("Missing values in each column:")
print(df.isnull().sum())

print("\nChoose how you want to handle missing data:")
print("1 - Mean")
print("2 - Median")
print("3 - Mode")
print("4 - Forward Fill")
print("5 - Backward Fill")

choice = input("Enter option number: ")

if choice == "1":
    print("\nApplying Mean Imputation...")
    for col in df.select_dtypes(include="number").columns:
        df[col] = df[col].fillna(df[col].mean())
    output_name = "mean_imputed.csv"

elif choice == "2":
    print("\nApplying Median Imputation...")
    for col in df.select_dtypes(include="number").columns:
        df[col] = df[col].fillna(df[col].median())
    output_name = "median_imputed.csv"

elif choice == "3":
    print("\nApplying Mode Imputation...")
    for col in df.columns:
        df[col] = df[col].fillna(df[col].mode()[0])
    output_name = "mode_imputed.csv"

elif choice == "4":
    print("\nApplying Forward Fill...")
    df = df.fillna(method="ffill")
    output_name = "forward_filled.csv"

elif choice == "5":
    print("\nApplying Backward Fill...")
    df = df.fillna(method="bfill")
    output_name = "backward_filled.csv"

else:
    print("Invalid choice.")
    exit()

print("\nMissing values after cleaning:")
print(df.isnull().sum())

df.to_csv(output_name, index=False)
print(f"\nDone! Cleaned file saved as '{output_name}'")