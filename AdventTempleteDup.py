import shutil
import datetime
import os

def Duplicate_File(source_file, dest_file):
    try:
        shutil.copyfile(source_file, dest_file)
        print("File duplicated successfully.")
    except Exception as e:
        print("Error duplicating file:", e)
def create_directory(directory):
    if not os.path.exists(directory):
        os.makedirs(directory)
        print("Directory created")
    else:
        print("Directory already exists")
def create_file(file_name):
    if not os.path.exists(file_name):
        with open(file_name, "w") as f:
            f.write("")
        print("File created")
    else:
        print("File already exists")
def getSamples():
    SampleList = []
    sampleFile=input("Enter the name of the file: ")
    while len(sampleFile)!=0:
        SampleList.append(sampleFile)
        sampleFile=input("Enter the name of the file: ")
    return SampleList

CURRENT_YEAR=datetime.datetime.now().year
MAIN_ROOT="/home/sontung/VScode/RootAndRoot"
SAMPLE_LIST=getSamples()
TAIL_LIST=[]
for sample in SAMPLE_LIST:
    TAIL_LIST.append(sample.split(".")[1])
    
for year in range(2015,CURRENT_YEAR+1):
    DirLevel1="Advent_of_code_"+str(year)
    create_directory(MAIN_ROOT+"/"+DirLevel1)
    for date in range (1,25+1):
        DirLevel2=DirLevel1+"_"+str(date)
        create_directory(MAIN_ROOT+"/"+DirLevel1+"/"+DirLevel2)
        FILENAME=DirLevel2+"output."
        for i in range(len(TAIL_LIST)):
            fileName=FILENAME+TAIL_LIST[i]
            fileDir=MAIN_ROOT+"/"+DirLevel1+"/"+DirLevel2+"/"+fileName
            Duplicate_File(SAMPLE_LIST[i],fileDir)
        create_file(MAIN_ROOT+"/"+DirLevel1+"/"+DirLevel2+"/"+FILENAME+"txt")
