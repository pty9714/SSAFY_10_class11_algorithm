import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        Set<Case> visited = new HashSet<>();
        PriorityQueue<Case> queue = new PriorityQueue<>(Comparator.comparingInt(Case::getRepeat));
        queue.add(new Case(1, 0, 0));
        visited.add(new Case(1, 0, 0));
        while (true) {
            Case current = queue.poll();
            if (current.getEmoji() == caseCount) {
                System.out.println(current.getRepeat());
                break;
            }
            for (Case next : current.getCases()) {
                if (visited.contains(next)) {
                    continue;
                }
                visited.add(next);
                queue.add(next);
            }
        }
    }

    public static class Case {
        private int emoji;
        private int clipboard;
        private int repeat;

        public Case(int emoji, int clipboard, int repeat) {
            this.emoji = emoji;
            this.clipboard = clipboard;
            this.repeat = repeat;
        }

        public List<Case> getCases() {
            List<Case> cases = new ArrayList<>();
            this.removeEmoji().ifPresent(cases::add);
            this.copyClipboard().ifPresent(cases::add);
            this.pasteClipboard().ifPresent(cases::add);
            return cases;
        }

        public int getEmoji() {
            return emoji;
        }

        public int getClipboard() {
            return clipboard;
        }

        public int getRepeat() {
            return repeat;
        }

        public void setClipboard(int clipboard) {
            this.clipboard = clipboard;
        }

        public Optional<Case> removeEmoji() {
            Case result = new Case(emoji - 1, clipboard, repeat + 1);
            if (result.getEmoji() == 0) {
                return Optional.empty();
            }
            return Optional.of(result);
        }

        public Optional<Case> copyClipboard() {
            if (this.getClipboard() == emoji) {
                return Optional.empty();
            }
            Case result = new Case(emoji, emoji, repeat + 1);
            return Optional.of(result);
        }

        public Optional<Case> pasteClipboard() {
            if (this.getClipboard() == 0) {
                return Optional.empty();
            }
            Case result = new Case(emoji + clipboard, clipboard, repeat + 1);
            return Optional.of(result);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Case)) {
                return false;
            }
            Case aCase = (Case) obj;
            return emoji == aCase.emoji && clipboard == aCase.clipboard;
        }

        @Override
        public int hashCode() {
            return Objects.hash(emoji, clipboard);
        }
    }

}

// 객체지향적으로 짜도록 노력
// Optional 사용법 봐두면 좋음