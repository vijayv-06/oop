# Multi-Threaded Log Analyzer (Mini Project-2_vijay)

## Objective
This mini-project demonstrates the use of **Java Concurrency**, including **Thread Pools**, **Callable tasks**, **Future results**, and **ConcurrentHashMap**, to analyze multiple log files at the same time.
It shows how multithreading improves performance compared to sequential processing by using parallel execution for analyzing logs and combining results safely.

---

## Features

- Analyze multiple log files concurrently
- Each log is processed by a separate worker thread
- Uses ExecutorService with a fixed thread pool
- Displays final summary of keyword counts
- Supports easy modification for real log files

### 1. LogProcessor.java
Represents the worker task (thread) that analyzes a single log file.

**Responsibilities:**
- Implements Callable<Map<String, Integer>>
- Reads a list of log lines
- Counts keywords such as:
 error, success, load
- Returns a map containing the keyword count for that file

**Key Methods:**
- call() → Processes the log and returns keyword counts

### 2. LogAnalyzer.java
Manages multithreading and result aggregation.
**Responsibilities:**
- Creates a thread pool using Executors.newFixedThreadPool()
- Submits each log to a worker thread
- Collects results using Future
- Merges all results into a ConcurrentHashMap
- Computes total execution time
- Shuts down the executor after processing

**Data Structures:**
- ExecutorService executor
- ConcurrentHashMap<String, Integer> globalCount

**Key Methods:**
- analyzeLogs(List<List<String>> allLogs) → 
 Runs all worker threads and combines results

### 3. MainDemo.java
Main application class that runs the program.
**Responsibilities:**
- Creates sample log data (or can load from files)
- Defines number of worker threads
- Calls LogAnalyzer to start multi-threaded processing
- Displays:
    - Final aggregated keyword counts
    - Total time taken

**Output:**
- Processing messages from threads
- Merged keyword count
- Total execution time in milliseconds

## Concurrency Strategy (Simple Explanation)
## Thread Pool (ExecutorService)
A fixed number of threads are reused to process log files efficiently.

### Callable Tasks
Used instead of Runnable so each worker can return a result map.

### Future Objects
Allow the program to wait for and collect results from each thread.

### ConcurrentHashMap
Ensures safe merging of keyword counts from multiple threads without data corruption.

## Example Output
Processing logs with 3 threads...<br>
Thread pool-1-thread-1 processed Log 1<br>
Thread pool-1-thread-2 processed Log 2<br>
Thread pool-1-thread-3 processed Log 3<br>

Aggregated Keyword Counts:<br>
{error=3, load=2, success=1}

Total Execution Time: 14 ms