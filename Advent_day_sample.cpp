// #include<iostream>
// #include<string>
// #include<vector>
// #include<fstream>

// std::vector<std::string> ReadFile(const std::string& filename) {
//     std::ifstream file(filename);
//     if(file.fail()){
//         std::cout << "Unable to open file " << filename << std::endl;
//         exit(EXIT_FAILURE);
//     }
//     std::vector<std::string> Report;
//     while(true){
//         //some code here
//     }
//     return Report;
// }
// void ProcessFile(const std::string& filename){
//     const std::vector<std::string> Report = ReadFile(filename);
//     //some code here
// }
// void Part1(){
//     //some code here
// }
// void Part2(){
//     //some code here
// }
// int main(){
//     const std::string filename = "input.txt";
//     std::vector<std::string> Report = ReadFile("input.txt");
//     std::cout << Report.size() << std::endl;
//     return 0;
// }