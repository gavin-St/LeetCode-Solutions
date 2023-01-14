public class MedianOfTwoSortedArrays {
    public static void main (String args[]){
        int arr[] = {1,2};
        int arr2[] = {3,4,5,6};
        System.out.println(findMedianSortedArrays(arr,arr2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2 - 1;

        if (nums1.length==0) return even? (double) (nums2[half] + nums2[half + 1]) / 2 : (double) nums2[half];
        if (nums2.length==0) return even? (double) (nums1[half] + nums1[half + 1]) / 2 : (double) nums1[half];

        if (nums1.length == nums2.length){
            if (nums1[half] <= nums2[0]){
                return (double) (nums1[half] + nums2[0]) / 2;
            }
            if (nums2[half] <= nums1[0]){
                return (double) (nums2[half] + nums1[0]) / 2;
            }
        }
        else if (nums1.length > nums2.length){
            if (nums1[half] <= nums2[0]){
                return even? (double) (nums1[half] + Math.min(nums1[half + 1], nums2[0])) / 2 : (double) nums1[half];
            }
        }
        else{
            if (nums2[half] <= nums1[0]){
                return even? (double) (nums2[half] + Math.min(nums2[half + 1], nums1[0])) / 2 : (double) nums2[half];
            }
        }

        int l1 = 0, r1 = nums1.length - 1, m1 = even?(l1 + r1 + 1) / 2 : (l1 + r1)/2 ;
        int l2 = 0, r2 = nums2.length - 1, m2 = (l2 + r2) / 2;
        //System.out.println("arr1: " + l1 + " " + m1 + " " + r1 );
            //System.out.println("arr2: " + l2 + " " + m2 + " " + r2 );

        double ans = 0; int min = Integer.MAX_VALUE;
        while(l1 != r1 && l2 != r2){
            if ((l1 + 1 == r1 || l2 + 1 == r2) && Math.max(nums1[m1], nums2[m2]) == min) break;
            min = Math.min(Math.max(nums1[m1], nums2[m2]), min);

            if(nums1[m1] > nums2[m2]){
                r1 = m1; l2 = m2;
                if(m1 - l1 < r2 - m2){
                    m1 -= (r1 - l1 + 1) / 2;
                    m2 += (r1 - m1);
                }
                else{
                    m2 += (r2 - l2 + 1) / 2;
                    m1 -= (m2 - l2);
                }
            }
            else{
                r2 = m2; l1 = m1;
                if(m2 - l2 < r1 - m1){
                    m2 -= (r2 - l2 + 1) / 2;
                    m1 += (r2 - m2);
                }
                else{
                    m1 += (r1 - l1 + 1) / 2;
                    m2 -= (m1 - l1);
                }
            }
            //System.out.println("arr1: " + l1 + " " + m1 + " " + r1 );
            //System.out.println("arr2: " + l2 + " " + m2 + " " + r2 );
            
        }
        if(even){
            int prev = 0;
            if(m1 == 0) prev = nums2[m2 - 1];
            else if (m2 == 0) prev = nums1[m1 - 1];
            else prev = Math.max(nums1[m1 - 1], nums2[m2 - 1]);
            ans = (double) (Math.max(nums1[m1], nums2[m2]) + Math.max(Math.min(nums1[m1], nums2[m2]), prev)) / 2;
        }
        else ans = Math.max(nums1[m1], nums2[m2]);
        return ans;
    }
}
