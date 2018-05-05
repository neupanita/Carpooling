<div class="addpost">
<form id="addpostform" class="form-horizontal" method="POST" action="Post">
  <div class="form-group">
    <label for="post"></label>
    <textarea class="form-control" id="post" rows="3" placeholder="Write your post here" name="post"></textarea>
  </div>
  <div class="form-group">
    <label for="posttype">Select Post Type</label>
    <select class="form-control" name="posttype">
      <option value="1">Offer</option>
      <option value="0">Request</option>
    </select>
  </div>
  <button type="submit" class="btn btn-primary">Post</button>
</form>
</div>