class Solution {
    public int solution(String dartResult) {
        int[] nums = new int[3];
        int idx = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            if(ch=='1' && dartResult.charAt(i+1)=='0'){
                nums[idx++] = 10;
                i++;
            }
            else if('0'<=ch && ch<= '9'){
                nums[idx++] = ch-'0'; 
            }
            else if(ch=='S'){
                nums[idx-1] *=1;
            }
            else if(ch=='D'){
                nums[idx-1] = (int)Math.pow(nums[idx-1], 2);
            }
            else if(ch=='T'){
                nums[idx-1] = (int)Math.pow(nums[idx-1], 3);
            }
            else if(ch=='*'){
                if(idx-2>=0){
                    nums[idx-2]*=2;
                }
                nums[idx-1]*=2;
            }
            else if(ch=='#'){
                nums[idx-1] *=-1;
            }
        }  
        return nums[0]+nums[1]+nums[2];
    }
}