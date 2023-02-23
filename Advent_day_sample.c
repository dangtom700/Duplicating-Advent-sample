// #include <stdio.h>
// #include <stdlib.h>

// char* read_text_file(const char* filename) {
//     FILE* fp;
//     char* contents;
//     long filesize;

//     // Open the file for reading
//     fp = fopen(filename, "r");
//     if (fp == NULL) {
//         fprintf(stderr, "Failed to open file '%s'\n", filename);
//         return NULL;
//     }

//     // Get the file size
//     fseek(fp, 0L, SEEK_END);
//     filesize = ftell(fp);
//     rewind(fp);

//     // Allocate memory for the file contents
//     contents = (char*)malloc(filesize + 1);
//     if (contents == NULL) {
//         fprintf(stderr, "Failed to allocate memory for file contents\n");
//         fclose(fp);
//         return NULL;
//     }

//     // Read the file contents into the buffer
//     fread(contents, 1, filesize, fp);
//     contents[filesize] = '\0';

//     // Close the file and return the contents
//     fclose(fp);
//     return contents;
// }
// void Part1(){

// }
// void Part2(){

// }
// int main(){
//     const char* filename="";
//     char* text = read_text_file(filename);
    
//     return 0;
// }