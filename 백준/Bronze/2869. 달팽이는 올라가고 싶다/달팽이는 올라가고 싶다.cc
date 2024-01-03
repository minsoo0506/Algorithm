#include <iostream>
using namespace std;

int main(){
    int A, B, V;
    int date = 0;
    
    cin >> A >> B >> V;
    
    /*
    x가 날이라고 하면
    Ax - B(x-1) = V 
    x = (V-B)/(A-B)
    */
    
    if(((V-B)%(A-B))==0){
        date = (V-B)/(A-B);
    }
    else{
        date = (V-B)/(A-B) + 1;
    }
    
    cout << date << "\n";
    return 0;
}