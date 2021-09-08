package spring.di.entity;

public class WakeExam implements Exam {
	private int kor;
	private int eng;
	private int math;
	private int com;
	@Override
	public int total() {
		return kor + eng + math + com;
	}

	@Override
	public double avg() {
		return total() / 4.0;
	}

}
