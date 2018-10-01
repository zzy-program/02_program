#include <iostream>
#include <string>
#include <cstdio>
#include <cstdlib>

using namespace std;

int main() {
	string s1 = string("s1");
	string s_empty = "";

	cout << "s1: " << s1  << ", length=" << s1.length() << endl;
	cout << "s_empty: " << s_empty << ", is empty: " << s_empty.empty() << endl;

	// c string test
	printf("s1: %s\n", s1.c_str());

	return 0;
}

// reference: http://www.cplusplus.com/reference/string/string/
