# Video Resource

## Required File: intro_video.mp4

Place your 4-second MP4 video file here with the name `intro_video.mp4`.

This video will play after the splash screen and before the Pokemon loading screen.

### Requirements:
- Format: MP4
- Duration: 4 seconds
- Resolution: Recommended 1080x1920 (portrait) or your preferred aspect ratio
- File name: `intro_video.mp4`

### Note:
The VideoIntroActivity is configured to:
- Play the video automatically
- Navigate to MainActivity after video completion
- Navigate to MainActivity after 4 seconds (failsafe timeout)
- Handle playback errors gracefully by skipping to MainActivity
