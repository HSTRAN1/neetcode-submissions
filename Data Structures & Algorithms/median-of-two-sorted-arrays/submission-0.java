class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftHalf = (nums1.length + nums2.length + 1)/2;
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }  
        int left = 0;
        int right = nums1.length;

        while (left <= right)
        {
            int cut1 = left + (right - left)/2;
            int cut2 = leftHalf - cut1;
            
            int left1 = (cut1 == 0)? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            
            int left2 = (cut2 == 0)? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 > right2){
                right = cut1 - 1;
            } else if (left2 > right1) {
                left = cut1 + 1;
            } else {
                int largestLeft = Math.max(left1,left2);
                if ((nums1.length + nums2.length)%2 == 0) {    
                    int smallestRight = Math.min(right1, right2);
                    return ((double)largestLeft + smallestRight)/2.0;
                } else {
                    return largestLeft;
                }
            }
        }
        throw new IllegalStateException("No valid partition found");
    }
}
