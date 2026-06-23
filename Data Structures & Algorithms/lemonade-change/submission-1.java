class Solution {
    int five_bills = 0;
    int ten_bills = 0;
    int twenty_bills = 0;
    public boolean lemonadeChange(int[] bills) {
        for(int i = 0; i < bills.length; i++){
            int n = bills[i];
            if(n==5){
                five_bills++;
            }
            if(n==10){
                if(five_bills<=0){
                    return false;
                }
                five_bills--;
                ten_bills++;
            }
            if(n==20){
                int bal = 15;
                if(ten_bills==0 && five_bills<3){
                    return false;
                }
                if(ten_bills>0){
                    ten_bills--;
                    bal = 5;
                }
                while(bal>0 && five_bills>0){
                    bal = bal - 5;
                    five_bills--;
                }
                if(bal!=0){
                    return false;
                }
                twenty_bills++;
            }
        }
        return true;
    }
}