#include <iostream>
#include <cstring>
using std::cout;
using std::endl;

class CBox
{
	public:
		CBox(double lv = 1.0, double wv = 1.0, double hv = 1.0):m_Length(lv), m_Width(wv), m_Height(hv) 
		{
			cout << "CBox constructor" << endl;	
		}
		
		double Volume() const
		{
			return m_Length*m_Width*m_Height;	
		}	
	private:
		double m_Length;
		double m_Width;
		double m_Height;
};

class CCandyBox: public CBox
{
	public:
		char *m_Contents;
		CCandyBox(double lv = 1.0, double wv = 1.0, double hv = 2.0, char *str = "Candy"):CBox(lv, wv, hv*5)
		{
			//CBox(lv, wv, hv);
			cout << "CCandyBox constructor" << endl;
			m_Contents = new char[strlen(str)+1];
			strncpy(m_Contents, str, strlen(str)+1);
		}		
		~CCandyBox()
		{delete[] m_Contents;}
};

int main()
{
	//CBox myBox(4.0, 3.0, 2.0);
	//CCandyBox myCandyBox;
	CCandyBox myMintBox;
	
	//cout << "sizeof myBox" << sizeof myBox << endl;
	//cout << "sizeof myCandyBox" << sizeof myCandyBox << endl;
	cout << "myMintBox volume is " << myMintBox.Volume() << endl;
	
	return 0;
}