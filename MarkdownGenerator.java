import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class MarkdownGenerator {

    static class BenchmarkResult {
        String label; // Previously 'language'
        long timeNs;
        double timeMs;
        double timeS;
        double percentSlower;

        BenchmarkResult(String label, long timeNs) {
            this.label = label;
            this.timeNs = timeNs;
            this.timeMs = timeNs / 1e6;
            this.timeS = timeNs / 1e9;
            this.percentSlower = 0.0;
        }
    }

    public static void main(String[] args) {
        String resultsDir = "results"; // Directory containing result files
        String outputFile = "results_summary.md"; // Output file in the current working directory

        try {
            // Read result files
            List<BenchmarkResult> results = Files.list(Paths.get(resultsDir))
                    .filter(path -> path.toString().endsWith("_result.json"))
                    .map(MarkdownGenerator::parseResult)
                    .collect(Collectors.toList());

            // Check if there are any results
            if (results.isEmpty()) {
                System.out.println("No result files found in directory: " + resultsDir);
                return;
            }

            // Sort results by time (ascending order)
            results.sort(Comparator.comparingLong(r -> r.timeNs));

            // Calculate percentage slower than the fastest
            long fastestTime = results.get(0).timeNs;
            for (BenchmarkResult result : results) {
                if (result.timeNs != fastestTime) {
                    result.percentSlower = ((double) (result.timeNs - fastestTime) / fastestTime) * 100;
                }
            }

            // Generate the markdown file
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                writer.println("# Prime Counting Benchmark Results\n");
                writer.println("This file contains the results of running a prime-counting algorithm across various programming languages and implementations.\n");
                writer.println("**Benchmark Details:**");
                writer.println("- Problem size: Count primes up to 1,000,000.");
                writer.println("- Environment: GitHub-hosted Ubuntu runners.");
                writer.println("- Timings: Only the second run of the algorithm is measured for warm-up optimization.\n");

                writer.println("| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |");
                writer.println("|----------------------|-------------------|-------------------|-------------------|-----------------------|");

                for (BenchmarkResult result : results) {
                    writer.printf("| %-20s | %-17d | %-17.2f | %-17.4f | %-21.2f |\n",
                            result.label,
                            result.timeNs,
                            result.timeMs,
                            result.timeS,
                            result.percentSlower);
                }

                writer.println("\n**Summary:**");
                writer.printf("- Fastest implementation: %s with %.2f ms (%.4f s).\n",
                        results.get(0).label, results.get(0).timeMs, results.get(0).timeS);
                writer.printf("- Slowest implementation: %s with %.2f ms (%.4f s).\n",
                        results.get(results.size() - 1).label,
                        results.get(results.size() - 1).timeMs,
                        results.get(results.size() - 1).timeS);
            }

            System.out.println("Markdown file generated successfully: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BenchmarkResult parseResult(Path filePath) {
        try {
            String content = new String(Files.readAllBytes(filePath)).trim();

            // Extract 'time_ns' using regex
            Pattern pattern = Pattern.compile("\"time_ns\"\\s*:\\s*(\\d+)");
            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                long timeNs = Long.parseLong(matcher.group(1));

                // Extract label from file name
                String label = filePath.getFileName().toString().replace("_result.json", "");

                return new BenchmarkResult(label, timeNs);
            } else {
                throw new RuntimeException("time_ns not found in file: " + filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading result file: " + filePath, e);
        }
    }
}