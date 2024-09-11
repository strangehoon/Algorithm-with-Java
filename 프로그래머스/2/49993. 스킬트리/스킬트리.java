class Solution {
    public int solution(String skill, String[] skill_trees) {

        int cnt = 0;
        for(String skill_tree : skill_trees){
            boolean flag = true;
            int std = Integer.MIN_VALUE;
            for(int i=0; i<skill.length(); i++){
                char ch = skill.charAt(i);
                int pos = skill_tree.indexOf(ch);
                if(pos==-1){
                    std = pos;
                }
                else if(std==-1 & pos!=-1){
                    flag = false;
                    break;
                }
                else if(std>pos){
                    flag = false;
                    break;
                }
                else{
                    std = pos;
                }
            }
            if(flag){
                cnt++;
            }
        }
        return cnt;
    }
}