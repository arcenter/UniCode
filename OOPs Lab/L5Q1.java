// Code by arcenter
// https://github.com/BPDC/

class q1 {
        public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                int candidates[] = {0, 0, 0, 0, 0, 0};
                int ballot;
                for (int i = 0; i < 15; i++) {
                        System.out.print("Enter Ballot Number (1-5) = ");
                        ballot = sc.nextInt();
                        if (ballot > 0 && ballot < 6)
                                candidates[ballot-1] += 1;
                        else
                                candidates[5] += 1;
                } for (int i = 0; i < 5; i++)
                        System.out.printf("Candidate %d got %d votes\n", i+1, candidates[i]);
                System.out.println("Spoilt Votes = " + candidates[5]);
        }
}

// Code by arcenter
// https://github.com/BPDC/
