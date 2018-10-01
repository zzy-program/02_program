// class example
#include <iostream>
using std::cout;
using std::endl;

class CBox
{
	public:
		static int obj_count;
		
		// constructor definition
		explicit CBox(double lv = 1.0, double bv = 1.0, double hv = 1.0)
		{
			cout << "Constructor called." << endl;
			m_Length = lv;
			m_Width = bv;
			m_Height = hv;
			
			obj_count++;
		}
		
		// function to calculate the volume of a box
		double Volume() const
		{
			return m_Length*m_Width*m_Height;	
		}
		
		// function to compare two boxes which returns true
		// if the first is greater than the second, and false otherwise
		bool Compare(CBox *pBox) const
		{
			if(!pBox)
			{
				return 0;	
			}
			return this->Volume() > pBox->Volume();
		}
		
		private:
			double m_Length;
			double m_Width;
			double m_Height;
};

int CBox::obj_count = 0;

int main()
{
	CBox boxes[5];
	CBox match(2.2, 1.1, 0.5);
	CBox cigar(8.0, 5.0, 1.0);
	CBox *pB1(&cigar);
	CBox *pB2(0);
	CBox *pB3;
	
	cout << "Address of cigar is " << pB1 << endl;
	cout << "Address of pB3 is " << pB3 << endl;
	cout << "Volume of cigar is " << pB1->Volume() << endl;
	cout << "Volume of pB3 is " << pB3->Volume() << endl; // ramdon result
	pB2 = &match;
	if(pB2->Compare(pB1))
	{
		cout << "match is greater than cigar" << endl;	
	}
	else
	{
		cout << "match is less than or equal to cigar" << endl;	
	}
	
	pB1 = boxes;
	boxes[2] = match;
	cout << "Volume of boxes[2] is " << (pB1+2)->Volume() << endl;
	cout << "Volume of boxes[3] is " << (pB1+3)->Volume() << endl;

	cout << "object count = " << CBox::obj_count << endl;

	return 0;	
}