<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class api extends CI_Controller {


public function get_member() {
	 $data = array();
         	$query = "select * from mahasiswa ";
            $q = $this->db->query($query)->result();
            $data=$q;
        echo json_encode($data);
}


public function detail () {
	$data = array();
	$id = $this->input->get('id_mhs');
	$query = "select * from mahasiswa where id_mhs='$id'";
	$q = $this->db->query($query)->result();
    $data=$q;
    echo json_encode($data);
}


public function pencarian() {
	$data = array();
	$nama_mhs = $this->input->get('nama_mhs');
	$query = "select * from mahasiswa where nama_mhs like '%$nama_mhs%'";
	$q = $this->db->query($query)->result();
	if ($q) {
		$data['result'] = 1;
		$data=$q;
	}
      else{
      	$data['result'] = 0;
      	$data ['pesan'] ='tidak ada';
      }
      echo json_encode($data);
}




public function hapusdata() {
	$data = array();
	$id_mhs = $this->input->get('id_mhs');
	$query = "delete from mahasiswa where id_mhs='$id_mhs'";
    $q = $this->db->query($query);
    if ($q) {
    	$data['result'] = 1;
		$data['pesan'] ='hapus berhasil';
	}
	else {
		$data['result'] = 0;
		$data ['pesan'] = 'gagal hapus';
	}
	echo json_encode($data);
}



public function editdata() {
	$data = array();
	$id_mhs = $this->input->get('id_mhs');
	$nama_mhs = $this->input->get('nama_mhs');
	$kelas_mhs= $this->input->get('kelas_mhs');

	$query="update mahasiswa set nama_mhs= '$nama_mhs', kelas_mhs = 
	'$kelas_mhs' where id_mhs = '$id_mhs'";

	$q = $this->db->query($query);
	if($q){
		$data['result']= 1;
		
	}
	else{
		$data ['result'] =0;
		
	}

	echo json_encode($data);
}


public function insertdata() {
	$data = array();
	$nama_mhs = $this->input->get('nama_mhs');
	$kelas_mhs = $this->input->get('kelas_mhs');

	$query = "insert into mahasiswa(nama_mhs, kelas_mhs) values ('$nama_mhs', '$kelas_mhs')";
	$q = $this->db->query($query);

	if ($q) {
		$data['result'] = 1;
	}

	else{
		$data['result'] = 0;
	}

	echo json_encode($data);
}


public function register() {
	$data = array();
	$username = $this->input->get('username');
	$email = $this->input->get('email');
	$password = $this->input->get('password');
	$md5 = md5($password);
	$query ="insert into user (username, email, password) values
	('$username','$email','$md5')";

	$q = $this->db->query($query);

	if ($q) {
		$data['result'] = 1;
		
	}
	else{
		$data['result'] = 0;
	}

	echo json_encode($data);
}

public function login() {
	$data = array();
		$email =  $this->input->get("email");
		$password =  $this->input->get("password");
		$md5 = md5($password);

		if($email == '' || $password == ''){
			$data['result'] = 0;

			echo json_encode($data);

			return;			
		}

		$this->db->where('email', $email);
		$this->db->where('password', $md5);
		
		$query = $this->db->get('user');
	
			if ($query->num_rows() >0) {
				$q = $query->row();

				$array1 = array();
				$array1['id_user'] = $q->id_user;
				$array1['username'] = $q->username;
				$array1['email'] = $q->email;
				
				$data['result'] = 1;
				$data['data'] = $array1;
			}
			else {
				$data['result']=0;

			}
		echo json_encode($data);	
	

}


}