#include <iostream>
using std::cout;
using std::endl;

class foo
{
	public:
		explicit foo(int ii):i(ii)
		{
			cout << "foo constructor" << endl;
		}
	private:
		int i;
};

int main()
{
#if 1
	foo f = foo(5);
#else  // error
	foo f = 5;
#endif

	return 0;	
}