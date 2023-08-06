package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Video;

@WebServlet({"/", "/index", "/video/detail","/favorite/home" })
public class homeServlet extends HttpServlet {
	// Create a list of Video objects
	private List<Video> videoList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("index")) {
			// Call the fillAll method to populate the request attribute with videoList
			fillAll(req);
			req.setAttribute("view", "/views/pages/home.jsp");
		} else if (uri.contains("video/detail")) {
			detail(req);

		}else if(uri.contains("favorite/home")) {
			req.setAttribute("view", "/views/pages/favorite.jsp");
		}
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();

		videoList = new ArrayList<>();
		videoList.add(
				new Video("qtb-nN3xiT4", "Binh đoàn người sắt", "binhdoannguoisat.jpg", 100, "Description 1", true));
		videoList.add(
				new Video("qtb-nN3xiT4", "Hiệp sĩ không gian", "hiepsikhonggian.jpg", 200, "Description 2", false));
		videoList.add(new Video("j65Sm4aJ5iI", "Xứ sở người cá", "susonguoica.jpg", 300, "Description 3", true));
		videoList.add(new Video("EYyVPVHnjiU", "Thám hiểm vùng đất mới", "chuyenlamhiemvungdatmoi.jpg", 300,
				"Description 4", true));
	}

	private Video getVideoById(String id) {
		for (Video video : videoList) {
			if (video.getId().equals(id)) {
				return video;
			}
		}
		return null;
	}

	// A method to fill the request attribute with videoList
	private void fillAll(HttpServletRequest req) {
		req.setAttribute("videoList", videoList);
	}

	private void detail(HttpServletRequest req) {
		String videoId = req.getParameter("id");
		Video selectedVideo = getVideoById(videoId);
		if (selectedVideo != null) {

			req.setAttribute("view", "/views/pages/detailVideo.jsp");
		} else {
			// Handle case when video is not found
			req.setAttribute("errorMessage", "Video not found.");
			req.setAttribute("view", "/views/pages/error.jsp");
		}
		req.setAttribute("video", videoList);
		req.setAttribute("Video", selectedVideo);
	}
}